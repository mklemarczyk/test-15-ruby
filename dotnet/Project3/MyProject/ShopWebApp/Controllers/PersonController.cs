using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ShopWebApp.Controllers
{
    public class PersonController : Controller
    {
        public ActionResult Index()
        {
            ViewBag.Title = "Person Index";

            var pp = new Models.AdventureWorksDataContext();

            var dat = from item in pp.Persons
                      select item;

            ViewBag.Persons = dat.Take(100);

            return View();
        }

        public ActionResult SortIndex1()
        {
            ViewBag.Title = "Sorted Person Index";

            var pp = new Models.AdventureWorksDataContext();

            var dat = (from item in pp.Persons
                       select item).ToArray();

            var ordered = (from item in dat
                           orderby item.LastName, item.FirstName
                           select item).ToArray();

            ViewBag.Persons = ordered.Take(100);

            return View();
        }

        public ActionResult SortIndex2()
        {
            ViewBag.Title = "Sorted Person Index";

            var pp = new Models.AdventureWorksDataContext();

            var dat = (from item in pp.Persons
                       orderby item.LastName, item.FirstName
                       select item).ToArray();

            var ordered = (from item in dat
                           select item).ToArray();

            ViewBag.Persons = ordered.Take(100);

            return View();
        }

        public ActionResult Create()
        {
            ViewBag.Title = "Home Page";

            var pp = new Models.AdventureWorksDataContext();

            var dat = from item in pp.Persons
                      select item;

            ViewBag.Persons = dat;

            return View();
        }
    }
}
