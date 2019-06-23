# PDFMerge

A simple utility for merging multiple pdfs into one file.

## Development

### Getting started

Assuming that both yarn and pip are available, the following will acquire the project's source code and its requirements
and start the development environment. When a change is detected in a file, webpack will rebundle the project and flask 
will serve it to `0.0.0.0:3000`

```
pip3 install flask
git clone https://github.com/Meebuhs/pdfmerge
cd pdfmerge/pdfmerge-web
yarn
yarn start
python3 pdfmerge.py
```

### Commands

| Command               | Description                                                         |
| --------------------- | ------------------------------------------------------------------- |
|`yarn build`           | Packs a production build.                                           |
|`yarn dev`             | Packs a development build.                                          |
|`yarn start`           | Watches for file changes and rebuilds when a change is detected.    |
| `python3 pdfmerge.py` | Starts the flask service deploying the static build on 0.0.0.0:3000 |

