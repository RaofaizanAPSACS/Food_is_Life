import React from "react";
import { Switch, Route, Redirect } from "react-router-dom";

// components

import Navbar from "components/Navbars/AuthNavbar.js";

// views

import AddLeftovers from "components/Leftovers/AddLeftovers";
import UpdateLeftovers from "components/Leftovers/UpdateLeftovers";

export default function Auth() {
  return (
    <>
      <Navbar transparent />
      <main>
        <section className="relative w-full h-full py-40 min-h-screen">
          <div
            className="absolute top-0 w-full h-full bg-blueGray-800 bg-no-repeat bg-full"
            style={{
              backgroundImage:
                "url(" + require("assets/img/register_bg_2.png").default + ")",
            }}
          ></div>
          <Switch>
            <Route
              path="/restaurant/AddLeftovers"
              exact
              component={AddLeftovers}
            />
            <Route
              path="/restaurant/UpdateLeftovers"
              exact
              component={UpdateLeftovers}
            />
            <Redirect from="/restaurant" to="/restaurant/leftovers" />
          </Switch>
        </section>
      </main>
    </>
  );
}
