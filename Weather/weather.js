const getWeather = function() {
    const zipcode = $("#zip").val()
    $.get (
        `http://api.openweathermap.org/data/2.5/weather?zip=${zipcode},US&appid=7cb9e933eaaf129c66194bac01c6b490&units=imperial`,
        function(data, textStatus, jqXHR) {
            $("#reportHeader").text(`${data.name}`)
            $("#weatherDesc").text(`${data.weather[0].description}`)
            let imageUrl = `http://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`
            $("#weatherIcon").attr("src", imageUrl)
            $("#currentTemp").text(`${data.main.temp} degree`)
            console.log(data)
            console.log(textStatus)
            console.log(jqXHR)
        }
    )
}

// icon
// description
// city name
