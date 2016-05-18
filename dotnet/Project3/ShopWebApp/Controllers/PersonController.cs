using ShopWebApp.Models;
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

            List<Person> list;

            using (var pp = new AdventureWorksDataContext())
            {
                list = (from item in pp.Persons
                        select item).ToList();
            }

            ViewBag.Persons = list.Take(100);

            return View();
        }

        public ActionResult SortIndex1()
        {
            ViewBag.Title = "Sorted Person Index";

            List<Person> list;

            using (var pp = new AdventureWorksDataContext())
            {
                var dat = (from item in pp.Persons
                           select item).ToArray();

                list = (from item in dat
                        orderby item.LastName, item.FirstName
                        select item).ToList();
            }

            ViewBag.Persons = list.Take(100);

            return View();
        }

        public ActionResult SortIndex2()
        {
            ViewBag.Title = "Sorted Person Index";

            List<Person> list;

            using (var pp = new AdventureWorksDataContext())
            {
                var dat = (from item in pp.Persons
                           orderby item.LastName, item.FirstName
                           select item).Take(100).ToArray();

                list = (from item in dat
                        select item).ToList();
            }

            ViewBag.Persons = list;

            return View();
        }

        // GET: Planes/Create
        public ActionResult Create()
        {
            ViewBag.Title = "Home Page";

            return View();
        }

        // POST: Planes/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "FirstName,LastName,Title")] Person person)
        {
            if (ModelState.IsValid)
            {
                using (var pp = new AdventureWorksDataContext())
                {
                    person.ModifiedDate = DateTime.Now;
                    person.PersonType = "EM";
                    person.BusinessEntityID = 1;

                    var businessEntity = new BusinessEntity();
                    businessEntity.ModifiedDate = DateTime.Now;
                    businessEntity.Person = person;
					businessEntity.rowguid = Guid.NewGuid( );

                    person.BusinessEntity = businessEntity;

                    pp.BusinessEntities.InsertOnSubmit(businessEntity);
                    pp.Persons.InsertOnSubmit(person);
                    pp.SubmitChanges();
                }

                return RedirectToAction("Index");
            }

            return View(person);
        }

    }
}
