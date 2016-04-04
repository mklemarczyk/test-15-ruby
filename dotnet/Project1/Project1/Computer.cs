using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Project1.Devices;

namespace Project1 {
	public class Computer {
		HashSet<BaseDevice> Devices => new HashSet<BaseDevice>( );

		public bool IsValid(out List<string> errors) {
			errors = new List<string>( );

			var motherboards = Devices.Where(x => x is Motherboard);
			if (!motherboards.Any( )) {
				errors.Add("Motherboard missing");
			} else if (motherboards.Count()>0){
				errors.Add("Too many botherboards");
			}else {
				var motherboard = motherboards.Single( );


			}

			if (errors.Any( ))
				return false;
			else
				return true;
		}
	}
}
