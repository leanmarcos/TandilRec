package com.tandilrec.TandilRec.modules.collections;

public enum CollectionResult {
    SUCCESS,
    NOT_OPENED,
    NOT_RECYCLABLE;

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }
}
