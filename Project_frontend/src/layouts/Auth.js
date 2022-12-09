import React from "react";
import { Switch, Route, Redirect } from "react-router-dom";

import OrderFoodItems from "components/NGO_operation/OrderFoodItems";
import AddRiderDetails from "components/NGO_operation/AddRiderDetails";
import Cart from "components/NGO_operation/Cart";
import SidenarNGO from "components/Sidebar/SidebarNGO";
import DisplayRiderDetails from "components/NGO_operation/DisplayRiderDetails";
import RemoveRiderDetails from "components/NGO_operation/RemoveRiderDetails";
import UpdateRiderDetails from "components/NGO_operation/UpdateRiderDetails";

export default function Auth() {
  return (
    <>
      <SidenarNGO />
      <div className="relative md:ml-64 bg-blueGray-100">
        <div className="px-4 md:px-10 mx-auto w-full -m-24">
          <Switch>
            <Route
              path="/auth/OrderFoodItems"
              exact
              component={OrderFoodItems}
            />
            <Route
              path="/auth/AddRiderDetails"
              exact
              component={AddRiderDetails}
            />
            <Route path="/auth/Cart" exact component={Cart} />
            <Route
              path="/auth/DisplayRiderDetails"
              exact
              component={DisplayRiderDetails}
            />
            <Route
              path="/auth/RemoveRiderDetails"
              exact
              component={RemoveRiderDetails}
            />
            <Route
              path="/auth/UpdateRiderDetails"
              exact
              component={UpdateRiderDetails}
            />

            <Redirect from="/auth" to="/auth/dashboard" />
          </Switch>
        </div>
      </div>
    </>
  );
}
