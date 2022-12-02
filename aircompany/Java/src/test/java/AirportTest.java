import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest 
{
	private static List<Plane> planes = Arrays.asList(new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
			new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
			new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
			new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
			new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
			new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
			new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
			new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
			new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.Bomber),
			new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.Bomber),
			new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.Bomber),
			new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.Fighter),
			new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.Fighter),
			new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.Transport),
			new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HighAtitude,
					ClassificationLevel.Secret),
			new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.Vtol,
					ClassificationLevel.TopSecret));

	private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500,
			242);

	@Test
	public void testGetTransportMilitaryPlanes() 
	{
		Airport airport = new Airport(planes);
		List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
		boolean hasTransportMilitaryPlanes = false;
		for (MilitaryPlane militaryPlane : transportMilitaryPlanes) 
		{
			if ((militaryPlane.getType() == MilitaryType.Transport)) 
			{
				hasTransportMilitaryPlanes = true;
				break;
			}
		}
		Assert.assertEquals(hasTransportMilitaryPlanes, true);
	}

	@Test
	public void testGetPassengerPlaneWithMaxCapacity() 
	{
		System.out.println("TEST testGetPassengerPlaneWithMaxCapacity started!");
		Airport airport = new Airport(planes);
		PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
		Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
	}

	@Test
	public void test3() {
		Airport airport = new Airport(planes);
		airport.sortByMaxLoadCapacity();
		List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

		boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
		for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) 
		{
			Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
			Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
			
			if (currentPlane.getMinLoadCapacity() > nextPlane.getMinLoadCapacity()) 
			{
				nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
				break;
			}
		}
		Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
	}

	@Test
	public void testHasAtLeastOneBomberInMilitaryPlanes() 
	{
		Airport airport = new Airport(planes);
		List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
		boolean hasBomberPlane = false;
		for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) 
		{
			if ((militaryPlane.getType() == MilitaryType.Bomber)) 
			{
				hasBomberPlane = true;
			} 
			else 
			{
				Assert.fail("Test failed!");
			}
		}
		// if not failed
	}

	@Test
	public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() 
	{
		Airport airport = new Airport(planes);
		List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
		boolean hasUnclassifiedPlanes = false;
		for (ExperimentalPlane ExperimentalPlane : experimentalPlanes) 
		{
			if (ExperimentalPlane.getClassificationLevel() == ClassificationLevel.UnClassified) 
			{
				hasUnclassifiedPlanes = true;
				break;
			}
		}
		Assert.assertFalse(hasUnclassifiedPlanes);
	}
}
