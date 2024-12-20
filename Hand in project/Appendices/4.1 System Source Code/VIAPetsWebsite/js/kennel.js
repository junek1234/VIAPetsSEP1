$.get("xml/kennel_xml.xml", function (xml, status) {


    $(xml).find("kennel").each(function () {
    
        var availableSlots = $(this).find("availableSlots").text();
        var txt=`<br><strong><u>${availableSlots}</u></strong> Open slots!`
        $("#availableSlots").html(txt)

    });
})