# Tailwind Reagent Workation App

This is a CLJS Reagent app that follows along with Tailwind's Workation screencast series.

## Overview

Original Tailwind screencast can be found at: https://tailwindcss.com/course/setting-up-tailwind-and-postcss

Demo site: https://tailwind-reagent.firebaseapp.com/

## Development

To get an interactive development environment run:

    make dev

To create css:

    make css-once
    
To watch for css changes:

    make css-watch

To clean all compiled files:

    make clean

To create a production build run:

	rm -rf target/public
	clojure -A:fig:min

