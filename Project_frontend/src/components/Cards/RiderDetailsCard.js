import React from "react";

const RiderDetailsCard = ({ person }) => {
  if (person.orderID === 0) {
    person.orderID = "No Order Assigned";
  } else {
    person.orderID = "Order Assigned";
  }
  return (
    <div className="cont">
      <div className="rider ">
        <img src={require("../../assets/images/rider.png").default} alt="1" />
        <div className="rider-card">
          <h3>{person.name}</h3>
          <div className="info-rider">
            <img src={require("../../assets/images/id.jpg").default} alt="2" />
            <p>{person.cnic}</p>
          </div>
          <div className="info-rider">
            <img
              src={require("../../assets/images/phone.jfif").default}
              alt="2"
            />
            <p>{person.phone}</p>
          </div>
          <div className="info-rider">
            <img
              src={require("../../assets/images/email.png").default}
              alt="3"
            />
            <p>{person.email}</p>
          </div>
          <div className="info-rider">
            <img
              src={require("../../assets/images/order.png").default}
              alt="3"
            />
            <p>{person.orderID}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RiderDetailsCard;
