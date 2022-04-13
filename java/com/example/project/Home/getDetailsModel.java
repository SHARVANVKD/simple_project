package com.example.project.Home;
public class getDetailsModel {

    private String courseName;
    private String courseimg;
    private String courseMode;
    private String courseTracks;

    public getDetailsModel(String courseName, String courseTracks, String courseMode, String courseImageURL) {
        this.courseName = courseName;
        this.courseTracks = courseTracks ;
        this.courseMode = courseMode ;
        this.courseimg = courseImageURL ;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseimg() {
        return courseimg;
    }

    public void setCourseimg(String courseimg) {
        this.courseimg = courseimg;
    }

    public String getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(String courseMode) {
        this.courseMode = courseMode;
    }

    public String getCourseTracks() {
        return courseTracks;
    }

    public void setCourseTracks(String courseTracks) {
        this.courseTracks = courseTracks;
    }
}
