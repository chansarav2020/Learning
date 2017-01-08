function getNiftyOptionQuote() {
  var ss = SpreadsheetApp.getActiveSpreadsheet(); //get active spreadsheet (bound to this script)
  var sheet = ss.getSheetByName('Options Prices List'); //The name of the sheet tab where you are sending the info
  //var range = sheet.getRange('A5-I21');
   var range = ss.getRange("Options Prices List!A4:I37");
  var values = range.getValues();
  var apiName='ajaxFOGetQuoteJSON.jsp'
  var underlying='NIFTY'
  var instrument='OPTIDX'
  var expiry='25JAN2017'
    var options = {
   method : 'GET',
   headers:{
      'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36',
      'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
      'Accept-Encoding': 'gzip, deflate, sdch, br',
      'Accept-Language': 'en-US,en;q=0.8',
      'Cookie': 'pointerfo=1; underlying1=NIFTY; instrument1=OPTIDX; optiontype1=CE; expiry1=; strikeprice1=8200.00; NSE-TEST-1=1843404810.20480.0000',
      'Connection': 'keep-alive',
      'Cache-Control': 'max-age=0',
      'Upgrade-Insecure-Requests': '1'

   },
   muteHttpExceptions : false,


 };
  for (var row in values) {
    var optionType=values[row][2]
    var optionstrikePrice=values[row][3]+".00";
    if(optionType!=''){
    var foUrl = 'https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/'+apiName+'?underlying='+underlying+'&instrument='+instrument+'&expiry='+expiry+'&type='+optionType+'&strike='+optionstrikePrice //api endpoint as a string
    var response = UrlFetchApp.fetch(foUrl,options); // get api endpoint
    var json = response.getContentText(); // get the response content as text
    var mae = JSON.parse(json); //parse text into json
    values[row][8] =mae.data[0].lastPrice
    Utilities.sleep(100)
    //sheet.getRange('I5').setValue(mae.data[0].lastPrice)
    }
  }
   range.setValues(values);


  var cell = sheet.getRange("B2");


  instrument='FUTIDX'
   var foUrl = 'https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/'+apiName+'?underlying='+underlying+'&instrument='+instrument+'&expiry='+expiry //api endpoint as a string
    var response = UrlFetchApp.fetch(foUrl,options); // get api endpoint
    var json = response.getContentText(); // get the response content as text
    var mae = JSON.parse(json); //parse text into json
    cell.setValue(mae.data[0].lastPrice);


  calcualteNiftyOptionThera()
}





function calcualteNiftyOptionThera() {
  var ss = SpreadsheetApp.getActiveSpreadsheet(); //get active spreadsheet (bound to this script)
  var sheet = ss.getSheetByName('Options Prices List'); //The name of the sheet tab where you are sending the info
  var rangeNifty = ss.getRange("Options Prices List!B2:C2");
  var niftyFOValue = rangeNifty.getCell(1, 1).getValue();

  //var range = sheet.getRange('A5-I21');
   var range = ss.getRange("Options Prices List!C4:K37");
  var values = range.getValues();
  for (var outerRow=0;outerRow< ((values.length/2)+1);outerRow++) {
    for (var innerRow in values){
      if(values[innerRow][0] =='PE' && values[innerRow][1]==values[outerRow][1]){
        if(niftyFOValue>values[innerRow][1])
        values[outerRow][8] =(niftyFOValue-values[innerRow][1])-(values[outerRow][6]-values[innerRow][6])
        else
        values[outerRow][8] =(values[innerRow][1]-niftyFOValue)-(values[innerRow][6]-values[outerRow][6])
      }
    }
  }
  range.setValues(values);

}
