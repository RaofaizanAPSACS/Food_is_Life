import React, { useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import LeftoversCard from "components/Cards/LeftoversCard";
function AddLeftovers() {
  const [foodItems, setFoodItems] = useState([{}]);

  return (
    <Container className=" text-right">
      <ToastContainer />
      <div className=" pt-20 mt-10">
        <h1 className="font-bold text-4xl text-center ">Add Leftovers Item</h1>
        <LeftoversCard />
      </div>
    </Container>
  );
}

export default AddLeftovers;
