$.get("../p/pets_xml.xml", function (xml, status) {

    var $container = $("#pet-container");

    $(xml).find("pet").each(function () {
        var $pet = $(this);
        var location = $pet.find("location").text();
        var status = $pet.find("status").text();
        var species ="-";
        if (location.toLowerCase() === "shop" && status.toLowerCase()==="not sold") {
            
            var id = $pet.find("id").text();
            var name = $pet.find("name").text();
            var type = $pet.find("type").text();
            var color = $pet.find("color").text();
            var age = $pet.find("age").text();
            var gender = $pet.find("gender").text();
            species=type;
            

            var price = $pet.find("price").text();

            let extraInfo = "";
            if (type.toLowerCase() === "fish") {
                var saltwater = $pet.find("saltwater").text();
                var species = $pet.find("species").text();
                var predator = $pet.find("predator").text();
                extraInfo = `
                                Saltwater: ${saltwater}<br>
                                Species: ${species}<br>
                                Predator: ${predator}<br>
                                `;
            }
            if (type.toLowerCase() === "dog" || type.toLowerCase() === "cat") {
                var breed = $pet.find("breed").text();
                var breederName = $pet.find("breederName").text();
                extraInfo = `
                                    Breed: ${breed}<br>
                                    Breeder Name: ${breederName}<br>
                                    `;
            }
            if (type.toLowerCase() === "bird") {

                var species = $pet.find("species").text();
                var preferredFood = $pet.find("preferredFood").text();
                extraInfo = `
                                        Species: ${species}<br>
                                        Preffered Food: ${preferredFood}<br>
                                        `;
            }
            if (type.toLowerCase() === "rodent" || type.toLowerCase() === "various") {
                var species = $pet.find("species").text();
                extraInfo = `
                                            Species: ${species}<br>
                                            `;
            }

            // Create pet card
            var petCard = `
                                <div class="col-12 col-sm-6 col-md-3 padding">
                                    <div class="cards_body">
                                        <p class="card_headers">${species.toUpperCase()}</p>
                                        <div class="card_line"></div>
                                        <div class="card">
                                            <img class="card-img-top" src="images/default.jpg" alt="defaultPhoto" style="width:100%">
                                                <div class="card-img-overlay h-100">
                                                    <div class="container h-100">
                                                        <div class="row h-100">
                                                            <div class="col-1"></div>
                                                            <div class="col-6 label">
                                                            <p class="labelInfo">
                                                                Name: ${name} <br>
                                                                ID: ${id}<br>
                                                                Color: ${color}<br>
                                                                Age: ${age}<br>
                                                                Gender: ${gender === "m" ? "Male" : "Female"}<br>
                                                                ${extraInfo}
                                                                Price: $${price}<br>
                                                            </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                        </div>
                                    </div>
                                </div>
                            `;
            $container.append(petCard);
        }

    });
})