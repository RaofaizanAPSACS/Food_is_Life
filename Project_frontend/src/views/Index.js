/*eslint-disable*/
import React from "react";
import { Link, Router, Route, Switch } from "react-router-dom";
import IndexNavbar from "components/Navbars/IndexNavbar.js";

export default function Index() {
  return (
    <>
      <IndexNavbar fixed />
      <section className="header relative pt-16 items-center flex h-screen max-h-860-px">
        <div className="container mx-auto items-center flex flex-wrap">
          <div className="w-full md:w-8/12 lg:w-6/12 xl:w-6/12 px-4">
            <div className="pt-32 sm:pt-0">
              <h2 className="font-bold text-4xl text-blue-600 text-center">
                FOOD IS LIFE
              </h2>
              <p className="mt-4 text-lg leading-relaxed text-blueGray-500 text-center">
                Our mission? To make sure good food gets eaten, not wasted.
                Every day, delicious, fresh food goes to waste at cafés,
                restaurants, hotels, shops and manufacturers - just because it
                hasn’t sold in time. The Food is Life website lets customers buy
                and collect Surprise Bags of food - at a great price - directly
                from businesses.
              </p>
              <div className="mt-12 text-center">
                <Link
                  to="/RegisterForRestaurant"
                  className="get-started text-white font-bold px-6 py-4 rounded outline-none focus:outline-none mr-1 mb-1 bg-lightBlue-500 active:bg-lightBlue-600 uppercase text-sm shadow hover:shadow-lg ease-linear transition-all duration-150"
                >
                  Register for Restaurant
                </Link>
                <Link
                  to="/RegisterForNGO"
                  className=" ml-1 text-white font-bold px-6 py-4 rounded outline-none focus:outline-none mr-1 mb-1 bg-blueGray-700 active:bg-blueGray-600 uppercase text-sm shadow hover:shadow-lg ease-linear transition-all duration-150"
                >
                  Register for NGO
                </Link>
              </div>
            </div>
          </div>
        </div>

        <img
          className="absolute top-0 b-auto right-0 pt-16 sm:w-6/12 -mt-48 sm:mt-0 w-10/12 max-h-600px"
          src={require("assets/img/pattern_react.png").default}
          alt="..."
        />
      </section>
    </>
  );
}
