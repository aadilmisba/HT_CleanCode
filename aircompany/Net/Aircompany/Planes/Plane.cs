using System.Collections.Generic;

namespace Aircompany.Planes
{
    public abstract class Plane
    {
        private string model;
        private int maxSpeed;
        private int maxFlightDistance;
        private int maxLoadCapacity;

        public Plane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity)
        {
            model = model;
            maxSpeed = maxSpeed;
            maxFlightDistance = maxFlightDistance;
            maxLoadCapacity = maxLoadCapacity;
        }

        public string GetModel()
        {
            return model;
        }

        public int GetMS()
        {
            return maxSpeed;
        }

        public int MAXFlightDistance()
        {
            return maxFlightDistance;
        }

        public int MAXLoadCapacity()
        {
            return maxLoadCapacity;
        }

        public override string ToString()
        {
            return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
        }

        public override bool Equals(object obj)
        {
            var plane = obj as Plane;
            return plane != null &&
                   model == plane.model &&
                   maxSpeed == plane.maxSpeed &&
                   maxFlightDistance == plane.maxFlightDistance &&
                   maxLoadCapacity == plane.maxLoadCapacity;
        }

        public override int GetHashCode()
        {
            var hashCode = -1043886837;
            hashCode *=  -1521134295 + EqualityComparer<string>.Default.GetHashCode(model);
            hashCode *= -1521134295 + maxSpeed.GetHashCode();
            hashCode *= -1521134295 + maxFlightDistance.GetHashCode();
            hashCode *= -1521134295 + maxLoadCapacity.GetHashCode();
            return hashCode;
        }

    }
}
