"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.King = void 0;
var ChessPiece_1 = require("./ChessPiece");
var Piece_1 = require("./Piece");
var King = /** @class */ (function (_super) {
    __extends(King, _super);
    function King(isWhite) {
        var _this = _super.call(this, Piece_1.PieceType.King, isWhite) || this;
        _this.generateMoves = function (moveOn, loc) {
            // this is the Move array that we will push
            var kingMoves = [];
            // initializing an array of position(row, col)
            var kingDirections = [];
            // xxrxx
            // xxrxx 
            // rrsrr starts at 2,2
            // xxrxx
            // xxrxx
            kingDirections.push({ row: 1, col: 1 });
            kingDirections.push({ row: 1, col: -1 });
            kingDirections.push({ row: -1, col: 1 });
            kingDirections.push({ row: -1, col: -1 });
            kingDirections.push({ row: 1, col: 0 });
            kingDirections.push({ row: 0, col: 1 });
            kingDirections.push({ row: -1, col: 0 });
            kingDirections.push({ row: 0, col: -1 });
            for (var _i = 0, kingDirections_1 = kingDirections; _i < kingDirections_1.length; _i++) {
                var direction = kingDirections_1[_i];
                var directionMoves = King.slidePiece(moveOn, loc, direction, _this.isWhite);
                kingMoves.push.apply(kingMoves, directionMoves);
            }
            return kingMoves;
        };
        return _this;
    }
    King.isOnBoard = function (loc) {
        return loc.col >= 0 && loc.col < 8 && loc.row >= 0 && loc.row < 8;
    };
    King.slidePiece = function (moveOn, loc, dir, isWhite) {
        var allMoves = [];
        var currentLoc = { row: loc.row + dir.row, col: loc.col + dir.col };
        if (King.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
            allMoves.push({ from: loc, to: currentLoc });
        }
        if (King.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) !== null) {
            if (moveOn.pieceAt(currentLoc).isWhite != isWhite) {
                allMoves.push({ from: loc, to: currentLoc });
            }
        }
        return allMoves;
    };
    return King;
}(ChessPiece_1.ChessPiece));
exports.King = King;
