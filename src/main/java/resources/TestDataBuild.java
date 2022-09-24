package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;
import pojo.reqresCreateUser;
import pojo.reqresUpdateUser;

public class TestDataBuild {
	
	public AddPlace addPlaceTestData() {

		AddPlace ap = new AddPlace();
		ap.setAccuracy(50);
		ap.setAddress("Chennai Bus Stand");
		ap.setLanguag("Tamil");
		ap.setName("Lan");
		ap.setPhone_number("2131321312");
		ap.setWebsite("www.ltm.com");

		List<String> typeList = new ArrayList<String>();
		typeList.add("Gamer");
		typeList.add("Boomer");
		ap.setTypes(typeList);

		Location lc = new Location();
		lc.setLat(-34.323123);
		lc.setLng(34.3123);
		ap.setLocation(lc);
		return ap;
	}
	
	public reqresCreateUser reqCreateUser() {
		reqresCreateUser cu=new reqresCreateUser();
		cu.setName("Lan");
		cu.setJob("gamer");
		return cu;
	}
	
	public reqresUpdateUser reqUpdateUser() {
		reqresUpdateUser uu=new reqresUpdateUser();
		uu.setName("Lan");
		uu.setJob("Gamer");
		return uu;
	}
	
}
