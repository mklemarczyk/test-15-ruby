using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project1.Interfaces {
	public class Ethernet : BaseInterface {
		public Speeds Speed;

		public enum Speeds {
			TenMb,
			OneHundertMd,
			OneGb
		}
	}
}
