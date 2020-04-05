package resources;


//enum jest specjalną klasą zawierającą kolekcje stałych i metod
public enum APIResourcesEnum {

    AddPlaceApi("/maps/api/place/add/json"),
    getAddPlaceAPI("/maps/api/place/get/json"),
    deleteAddPlaceAPI("/maps/api/place/delete/json");
    private String resource;

    APIResourcesEnum(String resource){
        this.resource=resource;
    }

    public String getResource()
    {
        return  resource;
    }
}
