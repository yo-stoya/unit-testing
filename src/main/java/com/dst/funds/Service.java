package com.dst.funds;

public  class Service
{
    private StringUtils stringUtils;

    public Service(StringUtils stringUtils) {
        this.stringUtils = stringUtils;
    }

    public String doShit() {
        String plain = "plainn";

        stringUtils.isEmpty(plain);

        return plain + " is ook";

  }

}
