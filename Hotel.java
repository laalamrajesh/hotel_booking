import java.util.*;
import java.io.*;

class Hotel
{

	List<Room> rooms = new ArrayList<Room>();

	void addRooms()
	{
		rooms.add(new Room(101, Constants.SINGLE_OCCUPANCY, Constants.AC , Constants.FIRST_FLOOR));
		rooms.add(new Room(102, Constants.DOUBLE_OCCUPANCY, Constants.AC , Constants.FIRST_FLOOR));
		rooms.add(new Room(103, Constants.DOUBLE_OCCUPANCY, Constants.NON_AC, Constants.FIRST_FLOOR ));
		rooms.add(new Room(104, Constants.TRIPLE_OCCUPANCY, Constants.NON_AC, Constants.FIRST_FLOOR));
		rooms.add(new Room(201, Constants.SINGLE_OCCUPANCY, Constants.AC, Constants.SECOND_FLOOR ));
		rooms.add(new Room(202, Constants.SINGLE_OCCUPANCY, Constants.NON_AC, Constants.SECOND_FLOOR));
		rooms.add(new Room(203, Constants.DOUBLE_OCCUPANCY, Constants.AC , Constants.SECOND_FLOOR));
		rooms.add(new Room(204, Constants.TRIPLE_OCCUPANCY, Constants.AC , Constants.SECOND_FLOOR));
		rooms.add(new Room(1000, Constants.TRIPLE_OCCUPANCY, Constants.AC, Constants.FIRST_FLOOR));
		rooms.add(new Room(205, Constants.TRIPLE_OCCUPANCY, Constants.NON_AC, Constants.SECOND_FLOOR));
	}

	Room get_available_room(String room_occupancy,boolean air_conditioned)
	{
		for(Room room : this.rooms)
		{
			boolean is_room_not_booked = room.availability == Constants.AVAILABLE;
			if( is_room_not_booked &&room.occupancy.equals(room_occupancy) && room.air_conditioned == air_conditioned )
				return room;
		}

		return null;
	}

	boolean bookRoom(String room_occupancy, String air_conditioned_type)
	{
		boolean air_conditioned = get_air_conditioned_boolean(air_conditioned_type);

		Room room = get_available_room(room_occupancy, air_conditioned);
		boolean room_available = room != null;
		if(room_available)
		{
			room.setUnAvailable();
			showRoomDetails(room);

			return room_available;
		}

		boolean no_rooms = room == null;
		return no_rooms;
	}


	void showRoomDetails(Room room)
	{
		System.out.print("Room Number : "+room.number+", ");
		boolean is_ac = room.air_conditioned == Constants.AC;

		System.out.print(room.floor+", ");

		if(is_ac)
			System.out.print("air-conditioned, ");
		else
			System.out.print("non-airconditioned, ");
		System.out.println("estimated: Rs. "+room.price+"/day");
	}

	boolean get_air_conditioned_boolean(String air_conditioned_type)
	{
		boolean is_ac = air_conditioned_type.equals(Constants.AC_STRING);
		if (is_ac)
			return Constants.AC;


		return Constants.NON_AC;
	}

}