import React from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
function AddFoodItems() {
  return (
    <Container>
      <ToastContainer />
      <div className="text-center pt-20 mt-10">
        <h1 className="font-bold text-4xl text-center ">Add Food Item</h1>
        <div className="contacts">
          <div className="contact-card">
            <img src="./images/mr-whiskerson.png" />
            <h3>Mr. Whiskerson</h3>
            <div className="info-group">
              <img src="./images/phone-icon.png" />
              <p>(212) 555-1234</p>
            </div>
            <div className="info-group">
              <img src="./images/mail-icon.png" />
              <p>mr.whiskaz@catnap.meow</p>
            </div>
          </div>
        </div>
      </div>
    </Container>
  );
}

export default AddFoodItems;
