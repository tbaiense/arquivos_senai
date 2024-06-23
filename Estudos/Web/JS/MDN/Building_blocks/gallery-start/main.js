const displayedImage = document.querySelector('.displayed-img');
const thumbBar = document.querySelector('.thumb-bar');

const btn = document.querySelector('button');
const overlay = document.querySelector('.overlay');

/* Declaring the array of image filenames */
const imgFilenames = [
    'pic1.jpg',
    'pic2.jpg',
    'pic3.jpg',
    'pic4.jpg',
    'pic5.jpg',
];
/* Declaring the alternative text for each image file */
const imgAlt = {
    pic1: 'eye',
    pic2: 'art',
    pic3: 'purple flowers',
    pic4: 'egypt',
    pic5: 'butterfly',
};

function displayImg(e) {
    displayedImage.src = e.currentTarget.src;
}
/* Looping through images */
for (let imgSrc of imgFilenames) {
    const newImage = document.createElement('img');
    const path = './images/' + imgSrc
    newImage.src = path;
    newImage.setAttribute('alt', imgAlt[`${imgSrc.slice(0,imgSrc.indexOf('.'))}`]);
    newImage.addEventListener('click', displayImg)
    thumbBar.appendChild(newImage);
}


/* Wiring up the Darken/Lighten button */
btn.addEventListener('click', () => {
    if (btn.getAttribute('class') !== 'dark') {
        overlay.style.backgroundColor = 'rgba(0 0 0 / 0%)';
        btn.textContent = 'Darken';
        btn.setAttribute('class', 'dark');
     } else {
        overlay.style.backgroundColor = 'rgba(0 0 0 / 50%)'; 
        btn.textContent = 'Lighten';
        btn.setAttribute('class', 'light');
    }
});