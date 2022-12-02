using Aircompany.Models;

namespace Aircompany.Planes
{
    public class MilitaryPlane : Plane
    {
        private MilitaryType type;

        public MilitaryPlane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type)
            : base(model, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            type = type;
        }


        public override bool Equals(object obj)
        {
            var plane = obj as MilitaryPlane;
            return plane != null &&
                   base.Equals(obj) &&
                   type == plane.type;
        }

        public override int GetHashCode()
        {
            var hashCode = 1701194404;
            hashCode *= -1521134295 + base.GetHashCode();
            hashCode *= -1521134295 + type.GetHashCode();
            return hashCode;
        }

        public MilitaryType PlaneTypeIs()
        {
            return type;
        }


        public override string ToString()
        {
            return base.ToString().Replace("}",
                    ", type=" + type +
                    '}');
        }
    }
}
