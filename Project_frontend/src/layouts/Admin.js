import React from "react";
import { Switch, Route, Redirect } from "react-router-dom";

// components

import Sidebar from "components/Sidebar/Sidebar.js";

// views

import AddFoodItems from "components/FoodItem/AddFoodItems";
import DisplayFoodItems from "components/FoodItem/DisplayFoodItems";
import UpdateFoodItems from "components/FoodItem/UpdateFoodItems";
import AddLeftovers from "components/Leftovers/AddLeftovers";
import UpdateLeftovers from "components/Leftovers/UpdateLeftovers";
import Order from "components/Leftovers/Order/Order";
import RemoveFoodItems from "components/FoodItem/RemoveFoodItems";

export default function Admin() {
  return (
    <>
      <div className="flex-row">
        <Sidebar />
        <div className="relative md:ml-64 bg-blueGray-100">
          <div className="px-4 md:px-10 mx-auto w-full -m-24">
            <Switch>
              <Route
                path="/admin/AddFoodItems"
                exact
                component={AddFoodItems}
              />
              <Route
                path="/admin/DisplayFoodItems"
                exact
                component={DisplayFoodItems}
              />
              <Route
                path="/admin/RemoveFoodItems"
                exact
                component={RemoveFoodItems}
              />
              <Route
                path="/admin/UpdateFoodItems"
                exact
                component={UpdateFoodItems}
              />
              <Route
                path="/admin/AddLeftovers"
                exact
                component={AddLeftovers}
              />
              <Route
                path="/admin/UpdateLeftovers"
                exact
                component={UpdateLeftovers}
              />
              <Route path="/admin/Order" exact component={Order} />

              <Redirect from="/admin" to="/admin/dashboard" />
            </Switch>
          </div>
        </div>
      </div>
    </>
  );
}
