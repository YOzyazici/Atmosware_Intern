document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    const button = form.querySelector('button');

    form.addEventListener('submit', function() {
        button.disabled = true;
        button.textContent = 'Searching...';
    });

    const resultItems = document.querySelectorAll('.result-item');
    resultItems.forEach(item => {
        item.addEventListener('mouseenter', () => {
            item.style.backgroundColor = '#f0f0f0';
        });
        item.addEventListener('mouseleave', () => {
            item.style.backgroundColor = '#fff';
        });
    });

    const toggleHeaders = document.querySelectorAll('.toggle-header');
    toggleHeaders.forEach(header => {
        header.addEventListener('click', () => {
            const content = header.nextElementSibling;
            const arrow = header.querySelector('.arrow');
            content.style.display = content.style.display === 'none' ? 'block' : 'none';
            arrow.classList.toggle('up');
        });
    });
});
