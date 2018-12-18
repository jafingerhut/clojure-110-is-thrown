# clojure-110-is-thrown

A minimal project demonstrating a difference between Clojure 1.9.0 and
Clojure 1.10.0.


## Usage

These tests all pass:

```bash
% lein with-profile +1.9 test
```

These tests fail, apparently on the test expression starting with `(is
(thrown-with-msg? ...` in file `core_test.clj`:

```bash
% lein with-profile +1.10 test
```


## License

Copyright © 2018 Andy Fingerhut

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
