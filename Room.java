class Room
{
	int number ;
	String occupancy;
	boolean air_conditioned;
	int price;
	boolean availability;
	int floor;

	Room( int number, String occupancy, boolean air_conditioned,int floor)
	{
		this.number = number;
		this.occupancy = occupancy;
		this.air_conditioned = air_conditioned;
		this.floor = floor;
		this.availability = Constants.AVAILABLE;
		set_room_price_on_occupacy_type();
		add_additional_charges();
	}

	void setUnAvailable()
	{
		this.availability = Constants.UN_AVAILABLE;
	}


	void set_room_price_on_occupacy_type()
	{
		if (this.occupancy.equals(Constants.SINGLE_OCCUPANCY))
		{
			this.price+=Constants.SINGLE_OCCUPANCY_PRICE;
		}
		else if (this.occupancy.equals(Constants.DOUBLE_OCCUPANCY))
		{
			this.price+=Constants.DOUBLE_OCCUPANCY_PRICE;
		}
		else if (this.occupancy.equals(Constants.TRIPLE_OCCUPANCY))
		{
			this.price+=Constants.TRIPLE_OCCUPANCY_PRICE;
		}
	}

	void add_additional_charges()
	{
		boolean is_ac = this.air_conditioned == Constants.AC;
		if(is_ac)
			this.price+=Constants.ADDITIONAL_CHARGE;

	}
}