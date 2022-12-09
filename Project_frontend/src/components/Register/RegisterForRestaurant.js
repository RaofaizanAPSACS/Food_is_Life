import axios from "axios";
import React, { useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export default function RegisterForRestaurant() {
  const [branchName, setBranchName] = useState();
  const [bid, setBid] = useState();
  const [city, setCity] = useState();
  const [branchEmail, setBranchEmail] = useState();
  const [openHourStart, setOpenHourStart] = useState();
  const [openHourEnd, setOpenHourEnd] = useState();
  const [branchPhone, setBranchPhone] = useState();
  const [branchState, setBranchState] = useState();
  const [branchAddress, setBranchAddress] = useState();
  const [adminUsername, setAdminUsername] = useState();
  const [password, setPassword] = useState();
  const [adminPhone, setAdminPhone] = useState();
  const [adminEmail, setAdminEmail] = useState();

  const handleBranchName = (event) => {
    setBranchName(event.target.value);
  };
  const handleBid = (event) => {
    setBid(event.target.value);
  };

  const hadnleCity = (event) => {
    setCity(event.target.value);
  };
  const handleBranchEmail = (event) => {
    setBranchEmail(event.target.value);
  };
  const handleOpenHourStart = (event) => {
    setOpenHourStart(event.target.value);
  };
  const handleOpenHourEnd = (event) => {
    setOpenHourEnd(event.target.value);
  };
  const handleBranchPhone = (event) => {
    setBranchPhone(event.target.value);
  };
  const handleBranchState = (event) => {
    setBranchState(event.target.value);
  };

  const handleBranchAddress = (event) => {
    setBranchAddress(event.target.value);
  };

  const handleAdminUsername = (event) => {
    setAdminUsername(event.target.value);
  };

  const handlePassword = (event) => {
    setPassword(event.target.value);
  };
  const handleAdminPhone = (event) => {
    setAdminPhone(event.target.value);
  };

  const handleAdminEmail = (event) => {
    setAdminEmail(event.target.value);
  };

  const handleApi = (e) => {
    // console.log(adminUsername);
    e.preventDefault();
    axios
      .post("http://localhost:8086/registerStore", {
        branch: {
          name: branchName,
          bid: bid,
          city: city,
          openHours: openHourStart + " " + openHourEnd,
          email: branchEmail,
          phone: branchPhone,
          state: branchState,
          address: branchAddress,
        },
        admin: {
          username: adminUsername,
          password: password,
          phone: adminPhone,
          email: adminEmail,
        },
      })
      .then((result) => {
        console.log(result.data);
        if (result.data === "Already have an account. Go for Login!") {
          alert("Already have an account. Go for Login!");
          message();
          window.location.href = "/LoginRestaurant";
        } else if ("Successfully Registered") {
          alert("Successfully Registered");
          success();
          window.location.href = "/LoginRestaurant";
        } else {
          alert(
            "Account already exists with same Admin Email! Try using different Email"
          );
          invalid();
        }
      })
      .catch((err) => console.log(err));
  };
  const message = () => {
    toast("Account Already Exist! Go for Login");
  };
  const success = () => {
    toast.success("Registered Successfully");
  };

  const invalid = () => {
    toast.warn(
      "Account already exists with same Admin Email! Try using different Email"
    );
  };

  return (
    <>
      <ToastContainer />
      <div className="container mx-auto px-4 h-full mt-12">
        <div className="flex content-center items-center justify-center h-full">
          <div className="w-full lg:w-6/12 px-4">
            <div className="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-blueGray-200 border-0">
              <div className="rounded-t mb-0 px-6 py-6">
                <div className="text-center mb-3">
                  <h1 className="font-bold text-4xl text-blue-600 text-center">
                    Register Restaurant
                  </h1>
                </div>
                <hr className="mt-6 border-b-1 border-blueGray-300" />
              </div>
              <div className="flex-auto px-4 lg:px-10 py-10 pt-0">
                <div className="text-blueGray-400 text-center mb-3 font-bold">
                  <small>Register with credentials</small>
                </div>
                <form onSubmit={handleApi}>
                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Restaurant Name
                    </label>
                    <input
                      type="text"
                      required={true}
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Restaurant Name"
                      value={branchName}
                      onChange={handleBranchName}
                    />
                  </div>
                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Branch ID
                    </label>
                    <input
                      type="text"
                      required={true}
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Branch ID"
                      value={bid}
                      onChange={handleBid}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Restaurant City
                    </label>
                    <input
                      type="text"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Restaurant City"
                      value={city}
                      onChange={hadnleCity}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Restaurant Email Address
                    </label>
                    <input
                      type="email"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Restaurant Email Address"
                      value={branchEmail}
                      required={true}
                      onChange={handleBranchEmail}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Open Hours Start Time
                    </label>
                    <input
                      type="time"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Start Time"
                      value={openHourStart}
                      onChange={handleOpenHourStart}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Open Hours End Time
                    </label>
                    <input
                      type="time"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="End Time"
                      value={openHourEnd}
                      onChange={handleOpenHourEnd}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Restaurant Phone
                    </label>
                    <input
                      type="tel"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Restaurant Phone"
                      value={branchPhone}
                      onChange={handleBranchPhone}
                      required={true}
                    />
                  </div>
                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Restaurant State
                    </label>
                    <input
                      type="text"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Restaurant State"
                      value={branchState}
                      onChange={handleBranchState}
                      required={true}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Restaurant Street
                    </label>
                    <input
                      type="text"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Street Details"
                      value={branchAddress}
                      onChange={handleBranchAddress}
                      required={true}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Admin Username
                    </label>
                    <input
                      type="text"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Admin Username"
                      value={adminUsername}
                      onChange={handleAdminUsername}
                      required={true}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Password
                    </label>
                    <input
                      type="password"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Password"
                      value={password}
                      onChange={handlePassword}
                      required={true}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Admin Phone
                    </label>
                    <input
                      type="tel"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Admin Phone"
                      value={adminPhone}
                      onChange={handleAdminPhone}
                      required={true}
                    />
                  </div>

                  <div className="relative w-full mb-3">
                    <label
                      className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
                      htmlFor="grid-password"
                    >
                      Admin Email
                    </label>
                    <input
                      type="email"
                      className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
                      placeholder="Admin Email"
                      value={adminEmail}
                      onChange={handleAdminEmail}
                      required={true}
                    />
                  </div>
                  <div className="text-center mt-6">
                    {/* <Link to="/admin/dashboard"> */}
                    <button
                      className="bg-blueGray-800 text-white active:bg-blueGray-600 text-sm font-bold uppercase px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 w-full ease-linear transition-all duration-150"
                      type="submit"
                    >
                      Create Account
                    </button>
                    {/* </Link> */}
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
