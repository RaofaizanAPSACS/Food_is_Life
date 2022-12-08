import React from "react";
const LeftoversCard = ({ items }) => {
  return (
    <div className="cont">
      <div className="contacts ">
        <div className="contact-card">
          <img
            src={require("../../assets/images/download_1.png").default}
            alt="1"
          />
          <h3>HELLO</h3>
          <div className="info-group">
            <img src={require("../../assets/images/id.jpg").default} alt="2" />
            <p>11</p>
          </div>
          <div className="info-group">
            <img src={require("../../assets/images/res.png").default} alt="2" />
            <p>LLLLL</p>
          </div>
          <div className="info-group">
            <img
              src={require("../../assets/images/description.jpg").default}
              alt="3"
            />
            <p>Mic Check</p>
          </div>
        </div>
        <form>
          <div className="relative w-full mb-3">
            <label
              className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
              htmlFor="grid-password"
            >
              Add Quantity
            </label>
            <input
              type="number"
              className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
              placeholder="Quantity"
              // value={adminEmail}
              // onChange={handleAdminEmail}
            />
          </div>
          <div className="relative  mb-3">
            <label
              className="block uppercase text-blueGray-600 text-xs font-bold mb-2"
              htmlFor="grid-password"
            >
              Best Before
            </label>
            <input
              type="date"
              className="border-0 px-3 py-3 placeholder-blueGray-300 text-blueGray-600 bg-white rounded text-sm shadow focus:outline-none focus:ring w-full ease-linear transition-all duration-150"
              // value={adminEmail}
              // onChange={handleAdminEmail}
            />
          </div>
        </form>
      </div>
    </div>
  );
};

export default LeftoversCard;
