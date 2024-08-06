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
            item.style.backgroundColor = '#f0f0f5';
        });

        item.addEventListener('mouseleave', () => {
            item.style.backgroundColor = '#fff';
        });
    });
});
