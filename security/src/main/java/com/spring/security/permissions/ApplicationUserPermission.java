package com.spring.security.permissions;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:read"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:read");

    private final String permissions;


    ApplicationUserPermission(String permissions) {
        this.permissions = permissions;
    }
    public String getPermissions(){
        return permissions;
    }
}
