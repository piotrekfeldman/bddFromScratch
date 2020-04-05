package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public AddPlace Data(String name, String language, String address)
    {
        AddPlace p=new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("648916216");
        p.setWebsite("onet.pl");
        p.setName(name);
        List<String> myList=new ArrayList<String>();
        myList.add("cpsds");
        myList.add("dsaa");
        p.setTypes(myList);
        Location l=new Location();
        l.setLat(50.3091283092);
        l.setLng(-32.901821);

        p.setLocation(l);
        return p;


    }

    public  String  deletePlacePayLoad(String placeId)
    {
        String delete= "{\n" +
                "    \"place_id\":\""+placeId+"\"\n" +
                "}\n";
        return  delete;
    }
}
