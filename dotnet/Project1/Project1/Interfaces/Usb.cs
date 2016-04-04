using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project1.Interfaces {
	public class Usb : BaseInterface {
		public Versions Version;

		public enum Versions {
			One,
			Two,
			Three
		}
	}
}
