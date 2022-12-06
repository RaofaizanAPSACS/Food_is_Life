import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

import "@fortawesome/fontawesome-free/css/all.min.css";
import "assets/styles/tailwind.css";

// layouts

import Admin from "layouts/Admin.js";
import Auth from "layouts/Auth.js";

// views without layouts

import Index from "views/Index.js";
import RegisterForNGO from "components/Register/RegisterForNGO";
import RegisterForRestaurant from "components/Register/RegisterForRestaurant";
import LoginRestaurant from "components/Login/LoginRestaurant";
import LoginNGO from "components/Login/LoginNGO";

ReactDOM.render(
  <BrowserRouter>
    <Switch>
      {/* add routes with layouts */}
      <Route path="/admin" component={Admin} />
      <Route path="/auth" component={Auth} />
      {/* add routes without layouts */}
      <Route path="/" exact component={Index} />
      <Route path="/RegisterForNGO" exact component={RegisterForNGO} />
      <Route
        path="/RegisterForRestaurant"
        exact
        component={RegisterForRestaurant}
      />
      <Route path="/LoginRestaurant" exact component={LoginRestaurant} />
      <Route path="/LoginNGO" exact component={LoginNGO} />
      {/* add redirect for first page */}
      <Redirect from="*" to="/" />
    </Switch>
  </BrowserRouter>,
  document.getElementById("root")
);
