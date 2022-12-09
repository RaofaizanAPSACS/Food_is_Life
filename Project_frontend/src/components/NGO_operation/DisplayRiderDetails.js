import React, { useEffect, useState } from "react";
import Container from "@material-ui/core/Container";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import axios from "axios";
import RiderDetailsCard from "components/Cards/RiderDetailsCard";
axios.defaults.withCredentials = true;
axios.defaults.headers.get["Access-Control-Allow-Origin"] = "*";
function DisplayRiderDetails() {
  const getAllRiders = () => {
    axios.post("http://localhost:8086/NGO/displayRiderDetails").then(
      (response) => {
        console.log(response.data);
        setRiders(response.data);
      },
      (error) => {
        console.log(error);
      }
    );
  };
  useEffect(() => {
    getAllRiders();
  }, []);

  const [riders, setRiders] = useState([
    {
      cnic: "",
      name: "",
      email: "",
      phone: "",
      orderID: 0,
    },
  ]);

  return (
    <Container className=" m-0 text-right">
      <ToastContainer />
      <div className=" pt-20 mt-10">
        <h1 className="font-bold text-4xl text-center ">RIDER INFORMATION</h1>
        {riders.length > 0
          ? riders.map((person) => <RiderDetailsCard person={person} />)
          : "No Riders"}
      </div>
    </Container>
  );
}

export default DisplayRiderDetails;
