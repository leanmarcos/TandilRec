package com.tandilrec.TandilRec.shared.utils.Auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 1. Busca el header "Authorization" en el request
        final String authHeader = request.getHeader("Authorization");

        // 2. Si no hay header o no empieza con "Bearer ", deja pasar sin autenticar
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response); // pasa al siguiente filtro
            return;
        }

        // 3. Extrae el token sacando el prefijo "Bearer " (7 caracteres)
        final String jwt = authHeader.substring(7);

        // 4. Extrae el username del token
        final String username = jwtService.extractUsername(jwt);

        // 5. Si hay username y el usuario AÚN no está autenticado en este request
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // 6. Carga el usuario desde la base de datos
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 7. Valida que el token sea válido y no esté vencido
            if (jwtService.isTokenValid(jwt, userDetails)) {

                // 8. Crea el objeto de autenticación con el usuario y sus roles
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null, // credentials: null porque ya validamos con JWT
                                userDetails.getAuthorities() // los roles del usuario
                        );

                // 9. Le agrega detalles del request (IP, session, etc.)
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 10. Guarda la autenticación en el contexto de seguridad
                // A partir de acá, Spring sabe que este request está autenticado
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // 11. Pasa al siguiente filtro (o al controller si era el último)
        filterChain.doFilter(request, response);
    }
}
