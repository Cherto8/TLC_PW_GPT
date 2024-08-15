import { chromium } from '@playwright/test'

//Function to launch Google Chrome
export async function launchChrome() {
    // Replace this path with the actual path to your Google Chrome executable
    const chromeExecutablePath = 'C:/Program Files/Google/Chrome/Application/chrome.exe'; // Update this path

    // Launch Google Chrome
    return await chromium.launch({
        executablePath: chromeExecutablePath,
        headless: false // Set to `true` if you want to run in headless mode
    });
}

//Wait Function
export function waitFor(seconds) {
        return new Promise(resolve => setTimeout(resolve, seconds * 1000));
    }