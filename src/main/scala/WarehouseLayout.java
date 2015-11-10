

import java.io.File;
import java.io.IOException;

public class WarehouseLayout {

	public WarehouseLayout() {
		
	}
	
	public void showImage(){
		try{
			File image = new File("Warehouse.png");
			Runtime.getRuntime().exec("cmd /c start " + image.getAbsolutePath());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
