// simple.js
console.log("Testttt");
var loadingTask = PDFJS.getDocument('/test.pdf');
loadingTask.promise.then(
	function (pdf) {
		// Load information from the first page.
		pdf.getPage(1).then(function (page) {
			var scale = 1;
			var viewport = page.getViewport(scale);

			// Apply page dimensions to the `<canvas>` element.
			var canvas = document.getElementById('pdf');
			var context = canvas.getContext('2d');
			canvas.height = viewport.height;
			canvas.width = viewport.width;

			// Render the page into the `<canvas>` element.
			var renderContext = {
				canvasContext: context,
				viewport: viewport,
			};
			page.render(renderContext).then(function () {
				console.log('Page rendered!');
			});
		});
	},
	function (reason) {
		console.error(reason);
	},
);
// // Get the canvas element.
// const canvas = document.getElementById('pdf-canvas');

// // Get the PDF file URL.
// const pdfUrl = 'test.pdf';

// pdfjsLib.GlobalWorkerOptions.workerSrc = './pdf.worker.js';

// // Load the PDF file using PDF.js.
// pdfjsLib.getDocument(pdfUrl).promise.then(function (pdfDoc) {
// 	// Get the first page of the PDF file.
// 	pdfDoc
// 		.getPage(1)
// 		.then(function (page) {
// 			const viewport = page.getViewport({ scale: 1 });

// 			// Set the canvas dimensions to match the PDF page size.
// 			canvas.width = viewport.width;
// 			canvas.height = viewport.height;

// 			// Set the canvas rendering context.
// 			const ctx = canvas.getContext('2d');

// 			const renderContext = {
// 				canvasContext: ctx,
// 				viewport: viewport,
// 			};

// 			// Render the PDF page to the canvas.
// 			page.render(renderContext);
// 		})
// 		.then(function () {
// 			console.log('Rendering complete');
// 		});
// });