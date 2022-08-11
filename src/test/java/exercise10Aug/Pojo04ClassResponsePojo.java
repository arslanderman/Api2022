package exercise10Aug;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pojo04ClassResponsePojo {

    /*
    {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        }
                                    "additionalneeds": "Breakfast with white tea"
                                     }
                                  }
     */

    private Integer bookingid;
    private Pojo04ClassExpectedData booking;

    public Pojo04ClassResponsePojo(Integer bookingid, Pojo04ClassExpectedData booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Pojo04ClassResponsePojo() {
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Pojo04ClassExpectedData getBooking() {
        return booking;
    }

    public void setBooking(Pojo04ClassExpectedData booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Pojo04ClassResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
