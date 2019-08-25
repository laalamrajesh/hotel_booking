import java.util.*;
import java.io.*;


public class HotelManagement
{

	public static void main(String[] args)
	{
		Hotel hotel = new Hotel();
		hotel.addRooms();
		hotel.addFloors();

		Scanner scanner = new Scanner(System.in);
		boolean repeat = true;
		while(repeat)
		{
			//hotel.showAvailableRooms();
			String room_type = scanner.next();
			String occupancy = scanner.next();
			String air_conditioned_type = scanner.next();

			String room_occupancy = room_type+ " " + occupancy;
			boolean booking_status = hotel.bookRoom(room_occupancy, air_conditioned_type);

			if(booking_status == false)
				System.out.println(room_occupancy +" "+ air_conditioned_type+" not available");

		}

	}
}