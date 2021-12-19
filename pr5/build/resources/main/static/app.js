var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/webs');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/response', function (response) {
            console.log(JSON.parse(response.body).name);
            console.log(JSON.parse(response.body).lastname);
            showResponse("Name: " + JSON.parse(response.body).name +"<br>Last name: " + JSON.parse(response.body).lastname);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({"name": $("#name").val(), "lastname": $("#lastname").val()}));
}

function sendId() {
    stompClient.send("/app/id", {}, JSON.stringify({"id": $("#id").val()}));
}

function showResponse(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#sendId" ).click(function() { sendId(); });
});

