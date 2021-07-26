package com.iitpkd.hospitalManagement.App.dto.NonEntities;

public class Authorization {
    private static Integer access_level;

    public static Integer getAccess_level() {
        return access_level;
    }

    public static void setAccess_level(Integer access_level) {
        Authorization.access_level = access_level;
    }
}
