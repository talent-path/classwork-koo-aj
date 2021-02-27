
const getStock = function() {
    const stockName = $("#ticker").val()
    if (stockName.length < 1) alert("Must enter in ticker symbol or company name.")
    else {
        
        $.get (
            `https://api.polygon.io/v2/reference/tickers?sort=ticker&search=${stockName}&perpage=50&page=1&apiKey=pbnV2dP9kMngpShCu4YvfZ4lJuUvtdzJ`,
            function(data, textStatus, jqXHR) {
                // console.log(`${data.tickers.[1]}`)
                $("#stockOptions").empty()
                for (let i = 0; i < data.tickers.length; i++) {
                    if (!data.tickers[i].ticker.includes("-") && 
                        (data.tickers[i].primaryExch === "NYE" || data.tickers[i].primaryExch === "NASDAQ")
                        && data.tickers[i].currency === "USD")
                    $("#stockOptions").append( `<option value="${data.tickers[i].ticker}">${data.tickers[i].name}</option>`);
                }
            }
        )
    }
}

let loadStockDate = function() {

    let ticker = $("#stockOptions").val()
    console.log(ticker);
    if (ticker === null) alert("PUT IN COMPANY NAME OR TICKER SYMBOL.")
    else {
        ticker = ticker.toUpperCase()
        const finalTicker = ticker
        const date = $("#date").val()
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        today = yyyy + '-' + mm + '-' + dd;
        if (date.length !== 10) alert("DATE IS NEEDED!") 
        else if (date === today) alert("Cannot choose current date")
        else
        $.get (
            `https://api.polygon.io/v1/open-close/${finalTicker}/${date}?unadjusted=true&apiKey=pbnV2dP9kMngpShCu4YvfZ4lJuUvtdzJ`,
            function(data, textStatus, jqXHR) {
                // console.log(`${data.symbol}`)
                $("#tickerSymbol").text(`Stock: ${data.symbol}`)
                $("#stockOpen").text(`Open: ${data.open}`)
                $("#stockLow").text(`Low: ${data.low}`)
                $("#stockHigh").text(`High: ${data.high}`)
                $("#stockClose").text(`Close: ${data.close}`)
            }
        )
    }
}