// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random fact to the page.
 */
function addRandomFacts() {
  const randomFacts = [
    "I have a twin brother",
    "Favorite ice cream flavor is pistachio",
  ];

  // Pick a random greeting.
  const fact = randomFacts[Math.floor(Math.random() * randomFacts.length)];

  // Add it to the page.
  const factContainer = document.getElementById("fact-container");
  factContainer.innerText = fact;
}

async function nextFibonnaci() {
  const responseFromServer = await fetch("/fib");
  const fib = await responseFromServer.json();

  const fibContainer = document.getElementById("fib-container");
  fibContainer.innerHTML = "";

  fibContainer.appendChild(
    createListElement("Previous fibonacci number: " + fib.prevFib)
  );
  fibContainer.appendChild(
    createListElement("Current fibonacci number: " + fib.currFib)
  );
  fibContainer.appendChild(
    createListElement("Next fibonacci number: " + fib.nextFib)
  );
}

/** Creates an <li> element containing text. */
function createListElement(text) {
  const liElement = document.createElement("li");
  liElement.innerText = text;
  return liElement;
}

/** Creates a map and adds it to the page. */
function createMap() {
  const map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 44.973, lng: -93.254 },
    zoom: 10,
  });
}
