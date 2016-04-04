using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Project1.Interfaces;

namespace Project1.Devices {
	public class HardDrive : BaseDevice {
		private static HashSet<BaseInterface> availableInterfaces = new HashSet<BaseInterface>(new BaseInterface[] { new Sata(), new Ata() } );
	}
}
