package pojo;

public class GetCourses {


    private String url;
    private String services;
    private pojo.Courses Courses;
    private String expertise;
    private String linkedin;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public pojo.Courses getCourses() {
        return Courses;
    }

    public void setCourses(pojo.Courses courses) {
        Courses = courses;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
