import { test, chromium } from '@playwright/test';
import { ai } from '@zerostep/playwright';
import assert from 'node:assert';
import { launchChrome, waitFor } from './utils.js';

test('Search - Search suggestion test', async ({ page }) => {
  const aiArgs = { page, test }
  const expectedSearchText = 'Order Statuses'

  await page.goto('https://toslc.thinkorswim.com')
  await ai('Click on the search box', aiArgs)
  await ai(`Type "${expectedSearchText}" in the search box`, aiArgs)
  await ai("Click on AutocompleteMenuItem__item__content", aiArgs)
  const actualSearchText = await ai('Get title', aiArgs)
  console.log('Actual Search Text: ', actualSearchText)
  assert(actualSearchText.includes(expectedSearchText))
})

test('Article - Video play test', async ({ page }) => {
   // Launch Chrome instead of the default Chromium
   const browser = await chromium.launch({channel: 'chrome', headless: true});
   const context = await browser.newContext();
   const newPage = await context.newPage(); // Use `newPage` instead of `page` to avoid conflict
   // An object with page and test must be passed into every call
   const aiArgs = { page: newPage, test };

   await newPage.goto('https://toslc.thinkorswim.com');
   await ai('Click on header link "thinkManual"', aiArgs);
   await ai("Scroll down", aiArgs);
   await ai("Click on the Overlay__playButton__icon button", aiArgs);
   await waitFor(5); //Wait for <seconds>
   const time = await ai("Get the text of the VideoPlayerControls__controls__time", aiArgs);
   assert.notEqual("00:00/00:00", time);
   console.log("Time: ", time)
   // Close the browser
   await browser.close();
})




