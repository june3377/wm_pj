#include <WiFi.h>
#include <WiFiClient.h>

#include "PubSubClient.h"
#define ON 101  
#define OFF 100
#define TOPIC "test"  
char ssid[] = "SK-207-222"; char password[] = "DONGGUK-AP12";
//byte server[] = {172,17,161,236}; // 성준
//byte server[] = {172,17,203,244}; // 동근
byte server[] = {172,17,12,14}; //중균
int port = 1883;
char clientId[8];
char topic[10];
int id = 1;
int minute=1;
int second=10;
byte byteMacAddr[6];
void msgReceived(char *topic, byte *payload, unsigned int uLen) {}
float volt;
int pin = A2;
char strValue[32];
int WasherStatus;
//char temp[32];
WiFiClient wClient;
PubSubClient client(server,port,wClient);
//PubSubClient client(server,port,msgReceived);
void setup() {
  Serial.begin(9600);
  if (WiFi.status() == WL_NO_SHIELD) {
    Serial.println("WiFi Shield Error");
    while(true);
    pinMode(pin, OUTPUT);
  }
  int status = 0;
  while(status != WL_CONNECTED) {
    Serial.println("Wait For Connect..");
    status = WiFi.begin(ssid, password);
    delay(1500);
  }
  Serial.println("Wi-Fi AP Connected!");
  snprintf(clientId, 8, TOPIC);
  Serial.println(client.connect(clientId));
  if (client.connect(clientId)) {
      sprintf(topic, TOPIC);
//    client.publish(TOPIC, "Hello, Arduino");
//    client.publish(TOPIC, "Arduino "+id);
//    client.publish(TOPIC, " Connected!");
  }
}

void loop() {
  // put your main code here, to run repeatedly:
  volt=(analogRead(0)/4.092)/10; //Read Analog Pin0, divide that by 4.092, and divide whats left by 10
 
/*Note: The value 4.092 was part of the (non-compiling) code included with the ‘voltage sensor’
that I purchase from eBay. I’m not 100% sure how it was calculated, but it works with a resolution
down to 0.1 so I kept using it. (It shows value to .01, but rounds up on the last digit) */
 
    Serial.print(volt); //Print the the variable to the serial terminal.
    Serial.println("V"); //Makes it pretty, also prints newline character.
    delay(1500); //Delays for 1 second. Without this, it would be hard to read the values.
    if( volt > 0.8) {
      digitalWrite(pin, HIGH);
      WasherStatus = ON;
    }else{
      digitalWrite(pin, LOW);
      WasherStatus = OFF;
    }
//    dtostrf(volt, 2, 2, temp);
    sprintf(strValue, "{\"ID\":%d,\"STATUS\":%d}", id, WasherStatus);
    client.publish(TOPIC, strValue);
}
