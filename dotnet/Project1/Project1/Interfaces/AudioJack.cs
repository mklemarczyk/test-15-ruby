using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project1.Interfaces {
	public class AudioJack : BaseInterface {
		public Sizes Size;

		public enum Sizes {
			TwoPointFive,
			ThreePointFive,
			SixPointThirtyFive,
		}
	}
}
